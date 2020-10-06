package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quest {

    JFrame window;
    Container container;
    JPanel titleName, startButtonPanel, mainTextPanel, optionButtonPanel, playerPanel;
    JLabel titleLabel, hpLabel, hpNumberLabel, weaponLabel, weaponObjectLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, optionFirst, optionSecond, optionThird, optionFourth;
    JTextArea mainTextArea;
    int playerHP;
    String playerWeapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    OptionHandler optionHandler = new OptionHandler();

    public static void main(String[] args) {
        new Quest();
    }

    public Quest() {
        window = new JFrame();
        window.setSize(850, 650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        container = window.getContentPane();

        titleName = new JPanel();
        titleName.setBounds(100, 100, 600, 150);
        titleName.setBackground(Color.BLACK);
        titleLabel = new JLabel("Dungeons & Dragons: Journey to the abyss");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        //startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleName.add(titleLabel);
        startButtonPanel.add(startButton);

        container.add(titleName);
        container.add(startButtonPanel);
    }

    public void createGameScreen() {

        titleName.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        container.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area.");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        optionButtonPanel = new JPanel();
        optionButtonPanel.setBounds(250, 350, 300, 200);
        optionButtonPanel.setLayout(new GridLayout(4, 1));
        optionButtonPanel.setBackground(Color.BLACK);
        container.add(optionButtonPanel);

        optionFirst = new JButton("Choice 1");
        optionFirst.setBackground(Color.BLACK);
        //optionFirst.setForeground(Color.white);
        optionFirst.setFont(normalFont);
        optionFirst.setFocusPainted(false);
        optionFirst.addActionListener(optionHandler);
        optionFirst.setActionCommand("option1");
        optionButtonPanel.add(optionFirst);

        optionSecond = new JButton("Choice 2");
        optionSecond.setBackground(Color.BLACK);
        // optionSecond.setForeground(Color.white);
        optionSecond.setFont(normalFont);
        optionSecond.setFocusPainted(false);
        optionSecond.addActionListener(optionHandler);
        optionSecond.setActionCommand("option2");
        optionButtonPanel.add(optionSecond);

        optionThird = new JButton("Choice 3");
        optionThird.setBackground(Color.BLACK);
        //optionThird.setForeground(Color.white);
        optionThird.setFont(normalFont);
        optionThird.setFocusPainted(false);
        optionThird.addActionListener(optionHandler);
        optionThird.setActionCommand("option3");
        optionButtonPanel.add(optionThird);

        optionFourth = new JButton("Choice 4");
        optionFourth.setBackground(Color.BLACK);
        //optionFourth.setForeground(Color.white);
        optionFourth.setFont(normalFont);
        optionFourth.setFocusPainted(false);
        optionFourth.addActionListener(optionHandler);
        optionFourth.setActionCommand("option4");
        optionButtonPanel.add(optionFourth);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1, 4));
        container.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.WHITE);
        playerPanel.add(hpLabel);

        hpNumberLabel = new JLabel();
        hpNumberLabel.setFont(normalFont);
        hpNumberLabel.setForeground(Color.WHITE);
        playerPanel.add(hpNumberLabel);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.WHITE);
        playerPanel.add(weaponLabel);

        weaponObjectLabel = new JLabel();
        weaponObjectLabel.setFont(normalFont);
        weaponObjectLabel.setForeground(Color.WHITE);
        playerPanel.add(weaponObjectLabel);

        playerStaff();
    }

    public void playerStaff() {
        playerHP = 100;
        playerWeapon = "Нож";
        hpNumberLabel.setText("" + playerHP);
        weaponObjectLabel.setText(playerWeapon);

        townGate();
    }

    public void townGate() {
        position = "townGate";

        mainTextArea.setText("Вы стоять на главной площади \nПеред вами есть паб \n\nЧто будете делать?");

        optionFirst.setText("Зайти в паб");
        optionSecond.setText("Осмотреться");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void lookTownGate() {
        position = "lookTownGate";

        mainTextArea.setText("Вокруг вас величественый город, стража в дорогих доспехах \nВогруг ходят дварфы, хафлинги, эльфы и люди. \n\nЧто будете делать?");

        optionFirst.setText("Зайти в паб");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void talkBarmen() {
        position = "talkBarmen";
        mainTextArea.setText("Бармен: Давно тебя не видеть, садись за третий столик");
        optionFirst.setText(">");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void pabTable() {
        position = "pabTable";
        mainTextArea.setText("Незнакомец: Приветсвую тебя. Слышал ты любишь приключения. Есть у меня для тебя дельце. \n\nРассказать?");
        optionFirst.setText("Рассказывай");
        optionSecond.setText("Я не при делах");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void tableTalk() {
        position = "tableTalk";
        mainTextArea.setText("Незнакомец: Смотри, недалеко есть пещера - старое убежище Риковсой гвардии. В нем есть небольшая библиотека. Мне нужна одна книга из нее \n\nТы готов?");
        optionFirst.setText("Я согласен");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void tableTalkError() {
        position = "tableTalkError";
        mainTextArea.setText("Сюжет мастера нельзя испортить. \n\nБыстро иди к приключениям.");
        optionFirst.setText("Я согласен");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void goToDungeon() {
        position = "goToDungeon";
        mainTextArea.setText("Вокруг вас красотища, реки поля, суслики");
        optionFirst.setText(">");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }


    public void attackMonster() {
        position = "attackMonster";
        mainTextArea.setText("Вы зашли в пещеру \nМонстрер: Агр-ррр \n\n(Бежит на вас и задевает вас, -29 HP)");
        playerHP = playerHP -29;
        hpNumberLabel.setText("" + playerHP);
        optionFirst.setText("Ударить");
        optionSecond.setText("Бежать");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void killMonster() {
        position = "killMonster";
        mainTextArea.setText("Монстра больше нет на вашем пути \n\nПродолжить путь");
        optionFirst.setText(">");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void lookDungeon() {
        position = "lookDungeon";
        mainTextArea.setText("Вы находитесь в старом убежище Риковсой гвардии. В центре стоит большая плита, которая раньше выполняла роль стола. На ней остались даже какие-то бумаги, но на них ничего нельзя прочесть. В углу находится проход в библиотеку \n\nПройти");
        optionFirst.setText(">");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void library() {
        position = "library";
        mainTextArea.setText("В библиотеке как ни странно сохранились все книги. Всего 3 шкафа с очень старыми книгами.");
        optionFirst.setText("Взять книгу");
        optionSecond.setText("Осмотреть стеллажи");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void lookLibrary() {
        position = "lookLibrary";
        mainTextArea.setText("В углу последнего стелажа вы находите натянутую веревку. Ее конец ведет к подпиленной балке. Видимо кто-то очень не хотель, чтобы посторонние были здесь");
        optionFirst.setText("Аккуратно взять книгу");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void lookBook() {
        position = "lookBook";
        mainTextArea.setText("Обложка книги выполнена из кожи, текст написан, как на клингонском, так и на каком-то очень дреанем языке. \nПролистав пару страниц вы находите чертеж, после которого вам стало понятно, кем был тот таинственный незнакомец");
        optionFirst.setText("Вернуться в паб");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void collapse() {
        position = "collapse";
        mainTextArea.setText("После того, как вы взяли книгу, все в пещере начало трястись. Вокруг ничего не видно из-за пыли. Вам нужно срочно выбираться. Вам следует срочно отдать эту книгу незнакомцу, иначе это приведет к большим неприятностям");
        optionFirst.setText("Вернуться к незнакомцу");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void talkBarmenSecond() {
        position = "talkBarmenSecond";
        mainTextArea.setText("Бармен: Как сходил? Садись за пятый столик");
        optionFirst.setText(">");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void returnTheBook() {
        position = "returnTheBook";
        mainTextArea.setText("Незнакомец: Наконец-то ты вернулся, где тебя так долго черти носили? Отдавай уже быстрее книгу и разойдемся");
        optionFirst.setText("Сомневаться");
        optionSecond.setText("Отдать книгу");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void doubt() {
        position = "doubt";
        mainTextArea.setText("Незнакомец: Так, что еще за выходки, это моя книга и она принодлежит мне по праву!");
        optionFirst.setText(">");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void sayTo() {
        position = "sayTo";
        mainTextArea.setText("Вы отказались отдавать книгу незнакомцу, но он ее выхватил");
        optionFirst.setText(">");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void getTheBook() {
        position = "getTheBook";
        mainTextArea.setText("После того как вы отдали книгу незнакомцу, он встал и вы поняли, что все это время вы работали на Ахрона - главного зладея Агрейского полуостров");
        optionFirst.setText(">");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
    }

    public void getTheBookSecond() {
        position = "getTheBookSecond";
        mainTextArea.setText("Продолжение следует");
        optionFirst.setText("");
        optionSecond.setText("");
        optionThird.setText("");
        optionFourth.setText("");
        optionFirst.setVisible(false);
        optionSecond.setVisible(false);
        optionThird.setVisible(false);
        optionFourth.setVisible(false);
    }


    public class TitleScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }

    public class OptionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();

            switch (position) {
                case "townGate":
                    switch (yourChoice) {
                        case "option1":
                            talkBarmen();
                            break;
                        case "option2":
                            lookTownGate();
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "lookTownGate":
                    switch (yourChoice) {
                        case "option1":
                            talkBarmen();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "talkBarmen":
                    switch (yourChoice) {
                        case "option1":
                            pabTable();
                            break;

                    }
                    break;
                case "pabTable":
                    switch (yourChoice) {
                        case "option1":
                            tableTalk();
                            break;
                        case "option2":
                            tableTalkError();
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "tableTalk":
                    switch (yourChoice) {
                        case "option1":
                            goToDungeon();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "tableTalkError":
                    switch (yourChoice) {
                        case "option1":
                            tableTalk();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "goToDungeon":
                    switch (yourChoice) {
                        case "option1":
                            attackMonster();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "attackMonster":
                    switch (yourChoice) {
                        case "option1":
                            killMonster();
                            break;
                        case "option2":
                            killMonster();
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "killMonster":
                    switch (yourChoice) {
                        case "option1":
                            lookDungeon();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "lookDungeon":
                    switch (yourChoice) {
                        case "option1":
                            library();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "library":
                    switch (yourChoice) {
                        case "option1":
                            collapse();
                            break;
                        case "option2":
                            lookLibrary();
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "lookLibrary":
                    switch (yourChoice) {
                        case "option1":
                            lookBook();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "lookBook":
                    switch (yourChoice) {
                        case "option1":
                            talkBarmenSecond();;
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "collapse":
                    switch (yourChoice) {
                        case "option1":
                            talkBarmenSecond();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "talkBarmenSecond":
                    switch (yourChoice) {
                        case "option1":
                            returnTheBook();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "returnTheBook":
                    switch (yourChoice) {
                        case "option1":
                            doubt();
                            break;
                        case "option2":
                            getTheBook();
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "doubt":
                    switch (yourChoice) {
                        case "option1":
                            sayTo();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "sayTo":
                    switch (yourChoice) {
                        case "option1":
                            getTheBook();
                            break;
                        case "option2":
                            break;
                        case "option3":
                            break;
                        case "option4":
                            break;
                    }
                    break;
                case "getTheBook":
                    switch (yourChoice) {
                        case "option1":
                            getTheBookSecond();
                            break;
                    }
                    break;
            }
        }
    }

}
