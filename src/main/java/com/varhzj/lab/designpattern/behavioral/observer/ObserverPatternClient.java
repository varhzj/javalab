package com.varhzj.lab.designpattern.behavioral.observer;

/**
 * Created by varhzj on 10/19/16.
 */
public class ObserverPatternClient {

    public static void main(String[] args) {
        NewsTopic topic = new NewsTopic();

        Observer observer1 = new NewsTopicSubscriber("Observer1");
        Observer observer2 = new NewsTopicSubscriber("Observer2");
        Observer observer3 = new NewsTopicSubscriber("Observer3");

        // register observers to subject
        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);

        // attach observer to subject
        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);

        // check if any update is available
        observer1.update();

        // send new message
        topic.postMessage("This is the message.");
    }

}
