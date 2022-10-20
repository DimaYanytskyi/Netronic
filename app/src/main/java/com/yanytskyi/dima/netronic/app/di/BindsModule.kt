package com.yanytskyi.dima.netronic.app.di

import com.yanytskyi.dima.netronic.data.repository.IUserProfilesRepository
import com.yanytskyi.dima.netronic.data.repository.UserProfilesRepository
import com.yanytskyi.dima.netronic.domain.interactor.user_profile.IUserProfileInteractor
import com.yanytskyi.dima.netronic.domain.interactor.user_profile.UserProfileInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BindsModule {

    @Binds
    @Singleton
    fun bindUserProfilesRepository(userProfilesRepository: UserProfilesRepository): IUserProfilesRepository

    @Binds
    @Singleton
    fun bindUserProfilesInteractor(userProfilesInteractor: UserProfileInteractor): IUserProfileInteractor
}