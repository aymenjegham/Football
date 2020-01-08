package com.angelstudio.football

import android.app.Application
import com.angelstudio.football.Network.*
import com.angelstudio.football.Repository.CompetitionsRepository
import com.angelstudio.football.Repository.CompetitionsRepositoryImpl
import com.angelstudio.football.UI.Competitions.CompetitionsViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class App : Application(), KodeinAware {
    override val kodein= Kodein.lazy {

        import(androidXModule(this@App))

        //bind() from singleton { TopHeadlineDatabase(instance()) }
       // bind() from singleton {instance<TopHeadlineDatabase>().topHeadlineDao() }
        bind<ConnectivityInterceptor>() with singleton {
            ConnectivityInterceptorImpl(
                instance()
            )
        }
        bind() from singleton {
            FootballApiService(
                instance()
            )
        }
        bind<CompetitionsDataSource>() with singleton {
            CompetitionsDataSourceImpl(
                instance()
            )
        }
        bind<CompetitionsRepository>() with singleton {
            CompetitionsRepositoryImpl(
                instance()
            )
        }


        bind() from provider {
            CompetitionsViewModelFactory(
                instance()
            )
        }
        //bind() from provider {ArchiveViewModelFactory(instance())}



    }

}
