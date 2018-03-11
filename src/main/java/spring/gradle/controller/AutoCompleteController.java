package spring.gradle.controller;


import spring.gradle.model.SearchString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arti on 8/26/17.
 */
@Controller
public class AutoCompleteController {

    List<SearchString> data = new ArrayList<SearchString>();

    AutoCompleteController() {
        // init data for testing
        data.add(new SearchString(1, "ruby"));
        data.add(new SearchString(2, "rails"));
        data.add(new SearchString(3, "c / c++"));
        data.add(new SearchString(4, ".net"));
        data.add(new SearchString(5, "python"));
        data.add(new SearchString(6, "java"));
        data.add(new SearchString(7, "javascript"));
        data.add(new SearchString(8, "jscript"));

    }

    @RequestMapping(value = "/autosearch", method = RequestMethod.GET)
    public ModelAndView getPages() {

        ModelAndView model = new ModelAndView("autosearch");
        return model;

    }


    @RequestMapping(value = "/getTags", method = RequestMethod.GET)
    public @ResponseBody
    List<SearchString> getTags(@RequestParam String tagName) {

        return simulateSearchResult(tagName);

    }


    private List<SearchString> simulateSearchResult(String tagName) {

        List<SearchString> result = new ArrayList<SearchString>();
//yo list lai object banaera pathauna jaskson bahen dependency halnu parxa
        // iterate a list and filter by tagName
        for (SearchString tag : data) {
            if (tag.getTagName().contains(tagName)) {
                result.add(tag);
            }
        }

        return result;
    }



}
