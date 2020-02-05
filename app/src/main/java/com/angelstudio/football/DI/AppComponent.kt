package com.angelstudio.football.DI

import android.app.Application
import com.angelstudio.football.App
import com.angelstudio.football.DI.Module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        CompetitionsModule::class,
        NetworkModule::class,
        AppModule::class,
        ViewModelModule::class,
        FragmentBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<App>
