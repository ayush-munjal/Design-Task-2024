package net.media.training.designpattern.observer;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 9:12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sun {
    private boolean isUp;
    private final List<Player> subscribers = new ArrayList<>();

    public void subscribe(Player player){
        this.subscribers.add(player);
    }

    public void unsubscriber(Player player){
        this.subscribers.remove(player);
    }

    public boolean isUp() {
        return isUp;
    }

    public void set() {
        isUp = false;

        for(Player player:subscribers){
            player.notifySunSet();
        }
    }

    public void rise() {
        isUp = true;

        for(Player player:subscribers){
            player.notifySunRose();
        }
    }
}