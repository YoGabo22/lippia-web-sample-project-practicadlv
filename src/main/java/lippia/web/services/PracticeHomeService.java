package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.PracticeHomeConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.ActionManager.click;
import static com.crowdar.core.actions.ActionManager.isPresent;

public class PracticeHomeService {

    public static void checksliders(int qSliders) {
        Assert.assertTrue(WebActionManager.getElements(PracticeHomeConstants.CONTAINER_SLIDERS).size() == qSliders);
    }

    public static void navigateToHomePage() {
        WebActionManager.navigateTo(PropertyManager.getProperty("web.base.url"));

    }

    public static void checksArrivals(int qArrivals) {
        Assert.assertTrue(WebActionManager.getElements(PracticeHomeConstants.CONTAINER_ARRIVALS).size() == qArrivals);
    }


    }
