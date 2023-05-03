package jessekind.silly.pigeons.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum CityPigeonVariant {
    DEFAULT(0),
    WHITE(1);

    private static final CityPigeonVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator
            .comparingInt(CityPigeonVariant::getId)).toArray(CityPigeonVariant[]::new);
    private final int id;

    CityPigeonVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static CityPigeonVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
