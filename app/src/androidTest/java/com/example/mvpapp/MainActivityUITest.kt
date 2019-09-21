package com.example.mvpapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.mvpapp.articleListMVP.ArticleActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Ahmed Abdullah on 9/21/2019.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {
    @Rule
    @JvmField
    var activityActivityTestRule: ActivityTestRule<ArticleActivity> =
        object : ActivityTestRule<ArticleActivity>(ArticleActivity::class.java) {

        }


    @Test
    @Throws(Exception::class)
    fun StartTheListApp() {
        Thread.sleep(6000)
        onView(withId(R.id.rvPosts)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
    }


}