package com.nazim.myapplication.common;

import com.nazim.myapplication.navigation.NavigationHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class AppModule {

    @Provides
    @Singleton
    NavigationHelper provideNavigationHelper() {
        return new NavigationHelper();
    }
}
