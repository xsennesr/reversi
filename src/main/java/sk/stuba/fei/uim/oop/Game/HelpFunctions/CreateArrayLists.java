package sk.stuba.fei.uim.oop.Game.HelpFunctions;

import sk.stuba.fei.uim.oop.Game.SearchDirections.*;
import sk.stuba.fei.uim.oop.Game.SearchDirections.SearchPossible;
import sk.stuba.fei.uim.oop.Game.TakeDirections.*;

import java.util.ArrayList;

public class CreateArrayLists {
    private final ArrayList<SearchPossible> searchPossibles;
    private final ArrayList<TakeOver> takeOver;

    public CreateArrayLists(){
        takeOver=new ArrayList<>();
        takeOver.add(new TakeUp());
        takeOver.add(new TakeRightUp());
        takeOver.add(new TakeRight());
        takeOver.add(new TakeRightDown());
        takeOver.add(new TakeDown());
        takeOver.add(new TakeLeftDown());
        takeOver.add(new TakeLeft());
        takeOver.add(new TakeLeftUp());

        searchPossibles=new ArrayList<>();
        searchPossibles.add(new SearchUp());
        searchPossibles.add(new SearchRightUp());
        searchPossibles.add(new SearchRight());
        searchPossibles.add(new SearchRightDown());
        searchPossibles.add(new SearchDown());
        searchPossibles.add(new SearchLeftDown());
        searchPossibles.add(new SearchLeft());
        searchPossibles.add(new SearchLeftUp());
    }
    public ArrayList<SearchPossible> getSearchPossibles() {
        return searchPossibles;
    }

    public ArrayList<TakeOver> getTakeOver() {
        return takeOver;
    }
}
