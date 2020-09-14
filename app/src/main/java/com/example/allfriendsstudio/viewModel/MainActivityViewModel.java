package com.example.allfriendsstudio.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.allfriendsstudio.model.FriendsService;
import com.example.allfriendsstudio.model.dataClass.ResponseData;
import com.example.allfriendsstudio.model.dataClass.UserProfileData;
import com.example.allfriendsstudio.model.di.ApiComponent;
import com.example.allfriendsstudio.model.di.ApiModule;
import com.example.allfriendsstudio.model.di.DaggerApiComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = "list_view_model";
    public MutableLiveData<ResponseData> responseDataMutableLiveData =
            new MutableLiveData<>();
    public MutableLiveData<Boolean> responseLoadingMutableLiveData =
            new MutableLiveData<>();
    public MutableLiveData<Boolean> responseErrorMutableLiveData =
            new MutableLiveData<>();
    @Inject
    FriendsService friendsService;
    private ApiComponent component;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainActivityViewModel() {
        component = DaggerApiComponent.builder().apiModule(new ApiModule()).build();
        component.inject(this);
    }


    public void getFriendsListAndUserProfile() {
        responseLoadingMutableLiveData.setValue(true);
        responseErrorMutableLiveData.setValue(false);
        compositeDisposable.add(
                friendsService.getResponse()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<ResponseData>() {
                            @Override
                            public void onSuccess(ResponseData responseData) {
                                Log.d(TAG, "onSuccess: ");
                                responseLoadingMutableLiveData.setValue(false);
                                if (responseData != null) {
                                    responseDataMutableLiveData.setValue(responseData);
                                    responseErrorMutableLiveData.setValue(false);
                                } else {
                                    responseErrorMutableLiveData.setValue(true);
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d(TAG, "onError: " + e.toString());
                                responseLoadingMutableLiveData.setValue(false);
                                responseErrorMutableLiveData.setValue(true);
                            }
                        })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
