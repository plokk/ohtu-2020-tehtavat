package statistics;

import java.util.List; 
import java.util.ArrayList; 

import statistics.matcher.*;

public class QueryBuilder {
    private List<Matcher> matchers = new ArrayList<Matcher>();

    public QueryBuilder() {
        matchers.add(new All());
    }

    public Matcher build() {
        Matcher[] arr = new Matcher[matchers.size()];
        for (int i = 0; i < matchers.size(); i++) {
            arr[i] = matchers.get(i);
        }
        matchers = new ArrayList<Matcher>();
        return new And(arr);
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }
}