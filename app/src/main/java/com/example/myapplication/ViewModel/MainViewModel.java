package com.example.myapplication.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Domain.BannerModel;
import com.example.myapplication.Domain.CategoryModel;
import com.example.myapplication.Domain.ItemsModel;
import com.example.myapplication.Respository.MainRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private final MainRepository repository=new MainRepository();
    public LiveData<ArrayList<CategoryModel>> loadCategory(){
        return repository.loadCategory();
    }

    public LiveData<ArrayList<BannerModel>> loadBanner(){
        return repository.loadBanner();
    }

    public LiveData<ArrayList<ItemsModel>> loadPopular(){
        return repository.loadPopular();
    }
}
