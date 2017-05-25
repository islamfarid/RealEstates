package com.example.islam.realestate.realestaeslist.view;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.islam.realestate.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by islam on 25/05/17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RealRstatesListTest {
    @Rule
    public IntentsTestRule<RealEstatesListActivity> activityRule =
            new IntentsTestRule<>(RealEstatesListActivity.class);

    /**
     * Prepare your test fixture for this test. In this case we register an IdlingResources with
     * Espresso. IdlingResource resource is a great way to tell Espresso when your app is in an
     * idle state. This helps Espresso to synchronize your test actions, which makes tests significantly
     * more reliable.
     */
    @Before
    public void registerIdlingResource() {
        Espresso.registerIdlingResources(
                activityRule.getActivity().getCountingIdlingResource());
    }

    @Test
    public void checkRealEstatesRecyclerViewISDisplayed() {
        onView(withId(R.id.recyclerview_real_estates))
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkWhenRealEstatesListLoadedLoadingBarIsHidden() {
        onView(withId(R.id.progressBar_loading))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test
    public void checkWhenRealEstatesListLoadedThirdPostionIsAdvertisement() {
        onView(withId(R.id.recyclerview_real_estates))
                .perform(RecyclerViewActions.scrollToPosition(2));
        onView(RecyclerViewMatcher.withRecyclerView(R.id.recyclerview_real_estates).atPosition(2))
                .check(matches(hasDescendant(withText("3"))));
    }

    @After
    public void unregisterIdlingResource() {
        Espresso.unregisterIdlingResources(
                activityRule.getActivity().getCountingIdlingResource());
    }


}