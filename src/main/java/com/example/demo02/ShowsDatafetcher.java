package com.example.demo02;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowsDatafetcher {
    private ArrayList<Show> shows = null;

    @PostConstruct
    public void init(){
        shows = new ArrayList<Show>();
        shows.add(new Show("Stranger Things", 2016));
        shows.add(new Show("Ozark", 2017));
        shows.add(new Show("The Crown", 2016));
        shows.add(new Show("Dead to Me", 2019));
        shows.add(new Show("Orange is the New Black", 2013));

    }

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        if(titleFilter == null) {
            return shows;
        }

        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }
}