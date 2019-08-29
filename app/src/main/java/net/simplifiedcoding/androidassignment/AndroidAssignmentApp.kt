package net.simplifiedcoding.androidassignment

import android.app.Application
import net.simplifiedcoding.androidassignment.data.db.AppDatabase
import net.simplifiedcoding.androidassignment.data.network.MyApi
import net.simplifiedcoding.androidassignment.data.network.NetworkConnectionInterceptor
import net.simplifiedcoding.androidassignment.data.repositories.QuotesRepository
import net.simplifiedcoding.androidassignment.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AndroidAssignmentApp : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@AndroidAssignmentApp))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { QuotesRepository(instance(), instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }
    }

}