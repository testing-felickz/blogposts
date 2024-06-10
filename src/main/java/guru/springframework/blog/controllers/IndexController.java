package guru.springframework.blog.controllers;


import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import guru.springframework.blog.Services.EventService;
import guru.springframework.blog.dto.Event;
import guru.springframework.blog.util.EncodeUtil;


@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    String index(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "index";
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public void log(@RequestBody Event event) {
        // Log the raw event
        logger.info(event.getEventId());
    }

    @RequestMapping(value = "/logEscaped", method = RequestMethod.POST)
    public void logEscaped(@RequestBody Event event) {
        // Log the escaped event directly
        logger.info(Encode.forJava(event.getEventId()));
    }


    @RequestMapping(value = "/logEscapedWrapper", method = RequestMethod.POST)
    public void logEscapedWrapper(@RequestBody Event event) {
        // Log the escaped event using a wrapper
        logger.info(EncodeUtil.encodeForJava(event.getEventId()));
    }

    @RequestMapping(value = "/logFakeWrapper", method = RequestMethod.POST)
    public void logFakeWrapper(@RequestBody Event event) {
        // Fake - do nothing
        logger.info(EncodeUtil.doNothing(event.getEventId()));
    }

    @RequestMapping(value = "/eventService", method = RequestMethod.POST)
    public void eventService(@RequestBody Event event) {
        // Call downstream service (that logs the raw event id)
        EventService eventService = new EventService();
        eventService.insertEvent(event);
    }

    @RequestMapping(value = "/eventServiceSanitized", method = RequestMethod.POST)
    public void eventServiceSanitized(@RequestBody Event event) {
        // Call downstream service (that logs the sanitized event id)
        EventService eventService = new EventService();
        eventService.insertEventSanitized(event);
    }
}

