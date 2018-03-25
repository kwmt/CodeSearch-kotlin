package net.kwmt27.codesearch.infrastructure.datasource

import net.kwmt27.codesearch.infrastructure.api.GithubApi
import net.kwmt27.codesearch.infrastructure.datesource.GithubApiDataSource
import net.kwmt27.codesearch.infrastructure.entity.mapper.EventEntityModelMapper
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GithubApiDataSourceTest {
    private lateinit var githubApiDataSource: GithubApiDataSource

    @Mock private lateinit var mockGithubApi: GithubApi
    private var mockEventEntityModelMapper = EventEntityModelMapper()

    @Before
    fun setup() {
        githubApiDataSource = GithubApiDataSource(mockGithubApi, EventEntityModelMapper())
    }

    // TODO: MockWebServerを使ったテストをする
    // https://github.com/kwmt/DroidKaigi2018UnitTestHandOn/blob/tasks/app/src/test/java/us/shiroyama/android/my_repositories/infrastructure/repository/datasource/remote/GitHubRestDataSourceTest.java
}

