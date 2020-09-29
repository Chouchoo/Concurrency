package com.Tap.Visibility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BetterList<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E item) {
        synchronized (list) {
            boolean absent = !list.contains(item);

            //Itt az én threadem elalszik
            list.add(item);

            if (absent) {
                list.add(item);
            }
            return absent;
        }
    }


}
