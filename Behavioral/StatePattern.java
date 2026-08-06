/*
The State Pattern allows an object to change its behavior when its internal state changes.
Instead of writing large if-else or switch statements, each state is represented by a separate class.

Think of a Vending Machine.

States:

No Coin
Coin Inserted
Dispensing
Out of Stock

The same button behaves differently depending on the current state.

*/

interface PlayerState {

    void pressButton(MusicPlayer player);
}

class StopState implements PlayerState {

    @Override
    public void pressButton(MusicPlayer player) {

        System.out.println("Playing Music");

        player.setState(new PlayState());
    }
}

class PlayState implements PlayerState {

    @Override
    public void pressButton(MusicPlayer player) {

        System.out.println("Paused");

        player.setState(new PauseState());
    }
}

class PauseState implements PlayerState {

    @Override
    public void pressButton(MusicPlayer player) {

        System.out.println("Resumed");

        player.setState(new PlayState());
    }
}

class MusicPlayer {

    private PlayerState state;

    public MusicPlayer() {

        state = new StopState();
    }

    public void setState(PlayerState state) {

        this.state = state;
    }

    public void pressButton() {

        state.pressButton(this);
    }
}

public class StatePattern {
    public static void main(String[] args) {

        MusicPlayer player = new MusicPlayer();

        player.pressButton();

        player.pressButton();

        player.pressButton();

        player.pressButton();
    }
}
