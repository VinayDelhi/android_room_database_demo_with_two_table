package com.demo.room.database3.di.modules

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.room.database3.MyApplication
import com.demo.room.database3.data.local.DatabaseService
import com.demo.room.database3.di.ApplicationContext
import com.demo.room.database3.di.DatabaseInfo
import com.demo.room.database3.di.NetworkInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {


    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String{

        return "abc"
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseVersion(): Int{

        return 1
    }

    @Provides
    @NetworkInfo
    fun provideApiKey():String{

        return "xyz"
    }

    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService = Room.databaseBuilder(

                    application,
                    DatabaseService::class.java,
                    "bootcamp-database-project-db"
              )
        .build()

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}