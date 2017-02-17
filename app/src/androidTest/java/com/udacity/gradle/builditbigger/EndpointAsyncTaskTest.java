package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.test.InstrumentationTestCase;

import com.example.jokeview.JokeActivity;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

/**
 * Created by gotit on 2/15/17.
 */

public class EndpointAsyncTaskTest extends InstrumentationTestCase {
    private static String mRootUrl = "http://192.168.100.52:8080/_ah/api/";
    private static boolean isCalled;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        isCalled = false;
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testReturnedValue_Not_Empty() throws Exception {
        new EndpointsAsyncTask(new EndpointsAsyncTask.OnAsynTaskListener() {
            @Override
            public void onFinish(String result) {
                assertTrue("Joke should not be empty", !"".equals(result));
            }
        }).execute(mRootUrl);
    }
}
