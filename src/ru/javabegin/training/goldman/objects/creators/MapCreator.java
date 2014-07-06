package ru.javabegin.training.goldman.objects.creators;

import ru.javabegin.training.goldman.abstracts.AbstractGameMap;
import ru.javabegin.training.goldman.enums.LocationType;
import ru.javabegin.training.goldman.interfaces.collections.GameCollection;
import ru.javabegin.training.goldman.objects.maps.FSGameMap;

public class MapCreator {

    private static MapCreator instance;

    public static MapCreator getInstance() {
        if (instance == null) {
            instance = new MapCreator();
        }
        return instance;
    }

    public AbstractGameMap createMap(LocationType type, GameCollection collection) {
        AbstractGameMap obj = null;

        switch (type) {
            case FS: {
                obj = new FSGameMap(collection);
                break;
            }
            case DB: {
                
                break;
            }
            default:
                throw new IllegalArgumentException("Can't create map type: " + type);

        }

        return obj;
    }
}
