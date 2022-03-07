package starter.lichess.screenplay.pages;

import net.serenitybdd.screenplay.targets.Target;

public class PlayPage {

    public static final Target CHESS_BOARD =
            Target.the("chess board").locatedBy(".main_board");
    public static final Target ONLINE_OPPONENT=
            Target.the("opponent user online").locatedBy(".ruser-top.online");
}
