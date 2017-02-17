package com.joke;

import java.util.ArrayList;
import java.util.Random;

public class JokeProvider {
    private ArrayList<Joke> mJokes;

    public JokeProvider() {
        //Get jokes from Endpoints
        mJokes = new ArrayList<>();
        mJokes.add(new Joke("First Joke."));
        mJokes.add(new Joke("Second Joke."));
        mJokes.add(new Joke("Third Joke."));
        mJokes.add(new Joke("Forth Joke."));
    }

    public ArrayList<Joke> getJokes() {
        return mJokes;
    }

    public int getSize() {
        return mJokes.size();
    }

    public Joke getJokeByIndex(int index) {
        if (index >= 0 && index < mJokes.size())
            return mJokes.get(index);
        else
            return null;
    }

    public Joke getRandomJoke(){
        return getJokes().get(new Random().nextInt(getSize()));
    }
}
