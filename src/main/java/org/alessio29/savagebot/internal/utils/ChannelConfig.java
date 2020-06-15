package org.alessio29.savagebot.internal.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.alessio29.savagebot.bennies.BennyColor;
import org.alessio29.savagebot.bennies.BennyType;

import java.util.*;

public class ChannelConfig {

    private static final int WHITE_COUNT = 20;
    private static final int RED_COUNT = 10;
    private static final int BLUE_COUNT = 5;
    private BennyType bennyType;
    private List<BennyColor> benniesPool = new ArrayList<>();

    public ChannelConfig() {
    }

    public ChannelConfig(BennyType type) {
        this.bennyType = type;
    }

    public BennyType getBennyType() {
        return this.bennyType;
    }

    public void setBennyType(BennyType type) {
        this.bennyType = type;
    }

    @JsonIgnore
    public boolean normalBennies() {
        return this.bennyType == BennyType.NORMAL;
    }

    @JsonIgnore
    public Map<BennyColor, Integer> pullBennies(int count) {
        if (benniesPool == null) {
            initBenniesPoool();
        }
        Map<BennyColor, Integer> map = new HashMap<>();

        for (int i = 0; i < count; i++) {
            BennyColor bennyColor = benniesPool.remove(benniesPool.size() - 1);
            Integer c = map.computeIfAbsent(bennyColor, bennyColor1 -> 0);
            c++;
            map.put(bennyColor, c);
        }
        return map;
    }

    @JsonIgnore
    public void initBenniesPoool() {
        for (int i = 0; i < WHITE_COUNT; i++) {
            benniesPool.add(BennyColor.WHITE);
        }
        for (int i = 0; i < RED_COUNT; i++) {
            benniesPool.add(BennyColor.RED);
        }
        for (int i = 0; i < BLUE_COUNT; i++) {
            benniesPool.add(BennyColor.BLUE);
        }
        Collections.shuffle(benniesPool);
    }

    @JsonIgnore
    public void addBennyToPool(BennyColor color) {
        benniesPool.add(color);
    }

}
