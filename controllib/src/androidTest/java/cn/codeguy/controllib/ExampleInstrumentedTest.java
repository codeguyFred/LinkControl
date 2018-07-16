package cn.codeguy.controllib;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import cn.codeguy.controllib.config.OptionsConfig;
import cn.codeguy.controllib.impl.ObserverAImpl;
import cn.codeguy.controllib.impl.ObserverBImpl;
import cn.codeguy.controllib.impl.ObserverCImpl;
import cn.codeguy.controllib.impl.ObserverDImpl;
import cn.codeguy.controllib.impl.ObserverEImpl;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("cn.codeguy.controllib.test", appContext.getPackageName());
    }

}
