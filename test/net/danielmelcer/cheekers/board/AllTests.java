package net.danielmelcer.cheekers.board;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBoard.class, TestBoardHistory.class, TestCoordinate.class, TestLegalMoves.class, TestMove.class,
		TestMoveResult.class, TestPieceType.class })
public class AllTests {

}
