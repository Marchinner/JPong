package ui;

public class Languages {

    public static String PLAY_BUTTON_TEXT;
    public static String EXIT_BUTTON_TEXT;
    public static String RESUME_BUTTON_TEXT;
    public static String RESTART_BUTTON_TEXT;
    public static String PLAYER_NAME_TEXT;
    public static String ENEMY_NAME_TEXT;
    public static String GAME_PAUSED_TEXT;
    public static String BACK_TO_MAIN_MENU_TEXT;

    public static final String PTBR_PLAY_BUTTON_TEXT = "JOGAR";
    public static final String PTBR_EXIT_BUTTON_TEXT = "SAIR";
    public static final String PTBR_RESUME_BUTTON_TEXT = "RESUMIR";
    public static final String PTBR_RESTART_BUTTON_TEXT = "REINICIAR";
    public static final String PTBR_PLAYER_NAME_TEXT = "Jogador";
    public static final String PTBR_ENEMY_NAME_TEXT = "Computador";
    public static final String PTBR_GAME_PAUSED_TEXT = "JOGO PAUSADO";
    public static final String PTBR_BACK_TO_MAIN_MENU_TEXT = "MENU PRINCIPAL";

    public static final String ENUS_PLAY_BUTTON_TEXT = "PLAY";
    public static final String ENUS_EXIT_BUTTON_TEXT = "EXIT";
    public static final String ENUS_RESUME_BUTTON_TEXT = "RESUME";
    public static final String ENUS_RESTART_BUTTON_TEXT = "RESTART";
    public static final String ENUS_PLAYER_NAME_TEXT = "Player";
    public static final String ENUS_ENEMY_NAME_TEXT = "Computer";
    public static final String ENUS_GAME_PAUSED_TEXT = "GAME PAUSED";
    public static final String ENUS_BACK_TO_MAIN_MENU_TEXT = "MAIN MENU";

    public Languages(Language language) {
        if (language == Language.ptBR) {
            PLAY_BUTTON_TEXT = PTBR_PLAY_BUTTON_TEXT;
            EXIT_BUTTON_TEXT = PTBR_EXIT_BUTTON_TEXT;
            RESUME_BUTTON_TEXT = PTBR_RESUME_BUTTON_TEXT;
            RESTART_BUTTON_TEXT = PTBR_RESTART_BUTTON_TEXT;
            PLAYER_NAME_TEXT = PTBR_PLAYER_NAME_TEXT;
            ENEMY_NAME_TEXT = PTBR_ENEMY_NAME_TEXT;
            GAME_PAUSED_TEXT = PTBR_GAME_PAUSED_TEXT;
            BACK_TO_MAIN_MENU_TEXT = PTBR_BACK_TO_MAIN_MENU_TEXT;
        } else if (language == Language.enUS) {
            PLAY_BUTTON_TEXT = ENUS_PLAY_BUTTON_TEXT;
            EXIT_BUTTON_TEXT = ENUS_EXIT_BUTTON_TEXT;
            RESUME_BUTTON_TEXT = ENUS_RESUME_BUTTON_TEXT;
            RESTART_BUTTON_TEXT = ENUS_RESTART_BUTTON_TEXT;
            PLAYER_NAME_TEXT = ENUS_PLAYER_NAME_TEXT;
            ENEMY_NAME_TEXT = ENUS_ENEMY_NAME_TEXT;
            GAME_PAUSED_TEXT = ENUS_GAME_PAUSED_TEXT;
            BACK_TO_MAIN_MENU_TEXT = ENUS_BACK_TO_MAIN_MENU_TEXT;
        }
    }
}
