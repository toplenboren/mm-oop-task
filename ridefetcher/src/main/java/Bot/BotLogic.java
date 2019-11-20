package Bot;

import TramFetching.EttuFetching;
import UserState.UserState;

class BotLogic {
    static String processCommand(String input, UserState state) {
        switch (state.getState()) {
            case "INIT": {
                switch (input) {
                    case "/help":
                        return BotUtility.getHelpMessage();
                    case "/fetch":
                        return EttuFetching.getTramString(EttuFetching.getTram(new String[] {"13", "15"},
                                EttuFetching.getHtmlDoc("http://m.ettu.ru/station/3417")));
                    default:
                        return "Я ничего не понимаю, пожлауйтса вызови помощь на /help";
                }
            }
            default:
                return "Что-то пошло не так..";
        }
    }
}
