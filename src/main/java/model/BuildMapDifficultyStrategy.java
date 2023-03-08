package model;

import java.io.IOException;

public interface BuildMapDifficultyStrategy {

	abstract void buildMap(DungeonMap dungeonMap) throws IOException;

}