package Game.Logic;

import Game.GUI.*;
import Game.GUI.Enemys.Mosca;
import Game.GUI.Enemys.Verme;
import Game.GUI.Frame;
import Game.Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;


public class Updater {
    private final int Movement_Speed = 5;
    private final long invulnerability = 5000;
    public static ArrayList<Shoot> shoots = new ArrayList<>();

    public Isaac isaac;
    private Ost ost;
    public DeathScreen ds;

    public Updater(Frame frame) {
        ds = new DeathScreen();
        ost = new Ost();
        Pannel pane = new Pannel(frame);
        isaac = frame.getIsaac();
        frame.setIconImage(new ImageIcon("src/Game/Sources/Misc/Icon.png").getImage());
    }
    boolean flag = true;
    public void update() {
        if (Game.frame.getPanel().getHeart().getHeartCount() == 0) {
            if (flag){
                Game.frame.panel.setVisible(false);
                flag = false;
                ds.refreshPoints();
                ds.setVisible(true);
                Game.frame.add(ds);
                Game.frame.setVisible(true);
            }
            isaac.state = State.Dead;
            ost.stop();
        }
        if (isaac.state == State.Alive) {
            movement();
            Game.frame.panel.room.enemyList.move();
            checkHit();
            for (int i = 0; i < shoots.size(); i++) {
                if (!shoots.get(i).moveShot()) {
                    for (int j = 0; j < Enemy.enemy.size(); j++) {
                        if (!Enemy.enemy.isEmpty()) {
                            if (Enemy.enemy.get(j) instanceof Mosca) {
                                if (shoots.get(i).intersects((Rectangle) Enemy.enemy.get(j))) {
                                    shoots.remove(i);
                                    if (((Mosca) Enemy.enemy.get(j)).removeLife()) {
                                        Enemy.enemy.remove(j);
                                        Enemy.updateTimer();
                                        ds.points += 10;
                                    }
                                    break;
                                }
                                continue;
                            } else if (Enemy.enemy.get(j) instanceof Verme) {
                                if (shoots.get(i).intersects((Rectangle) Enemy.enemy.get(j))) {
                                    shoots.remove(i);
                                    if (((Verme) Enemy.enemy.get(j)).removeLife()) {
                                        Enemy.enemy.remove(j);
                                        Enemy.updateTimer();
                                        ds.points += 10;
                                        j--;
                                    }
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                } else {
                    shoots.remove(i);
                }
            }
        }
    }

    public static void shoot(Isaac isaac) {
        if (isaac.state == State.Alive) {
            shoots.add(new Shoot(isaac));
        }
    }

    static boolean timer = true;

    public void checkHit() {
        if (isaac.state == State.Alive) {
            boolean flag = false;
            for (int i = 0; i < Enemy.enemy.size(); i++) {
                if (Enemy.enemy.get(i) instanceof Mosca || Enemy.enemy.get(i) instanceof Verme) {
                    if (isaac.intersects((Rectangle) Enemy.enemy.get(i))) {
                        flag = true;
                    }
                }
            }

            if (flag) {
                Timer t = new Timer(5000, new HitCD());
                if (timer) {
                    HitIsaccSounds hitIsaccSounds = new HitIsaccSounds();
                    Game.frame.getPanel().getHeart().removeHeart();
                    timer = false;
                    flag = false;
                    t.start();
                } else {
                    t.stop();
                }

            }
        }
    }


    private void movement() {
        if (isaac.state == State.Alive) {
            switch (isaac.currentDirection) {
                case Direction.Up:
                    if ((isaac.y - Movement_Speed) >= 80) {
                        if (!Enemy.enemy.isEmpty()) {
                            for (Object enemy : Enemy.enemy) {
                                if (enemy instanceof Mosca) {
                                    if (!isaac.intersects((Mosca) enemy)) {
                                        isaac.y -= Movement_Speed;
                                        break;
                                    }
                                }
                                if (enemy instanceof Verme) {
                                    if (!isaac.intersects((Verme) enemy)) {
                                        isaac.y -= Movement_Speed;
                                        break;
                                    }
                                }
                            }
                        } else {
                            isaac.y -= Movement_Speed;
                        }
                    }
                    break;
                case Direction.Down:
                    if (((isaac.y + Movement_Speed) <= 750)) {
                        if (!Enemy.enemy.isEmpty()) {
                            for (Object enemy : Enemy.enemy) {
                                if (enemy instanceof Mosca) {
                                    if (!isaac.intersects((Mosca) enemy)) {
                                        isaac.y += Movement_Speed;
                                        break;
                                    }
                                }
                                if (enemy instanceof Verme) {
                                    if (!isaac.intersects((Verme) enemy)) {
                                        isaac.y += Movement_Speed;
                                        break;
                                    }
                                }
                            }
                        } else {
                            isaac.y += Movement_Speed;
                        }
                    }
                    break;
                case Direction.Left:
                    if ((isaac.x - Movement_Speed) >= 170) {
                        if (!Enemy.enemy.isEmpty()) {
                            for (Object enemy : Enemy.enemy) {
                                if (enemy instanceof Mosca) {
                                    if (!isaac.intersects((Mosca) enemy)) {
                                        isaac.x -= Movement_Speed;
                                        break;
                                    }
                                }
                                if (enemy instanceof Verme) {
                                    if (!isaac.intersects((Verme) enemy)) {
                                        isaac.x -= Movement_Speed;
                                        break;
                                    }
                                }
                            }
                        } else {
                            isaac.x -= Movement_Speed;
                        }
                    }
                    break;
                case Direction.Right:
                    if ((isaac.x + Movement_Speed) <= 1525) {
                        if (!Enemy.enemy.isEmpty()) {
                            for (Object enemy : Enemy.enemy) {
                                if (enemy instanceof Mosca) {
                                    if (!isaac.intersects((Mosca) enemy)) {
                                        isaac.x += Movement_Speed;
                                        break;
                                    }
                                }
                                if (enemy instanceof Verme) {
                                    if (!isaac.intersects((Verme) enemy)) {
                                        isaac.x += Movement_Speed;
                                        break;
                                    }
                                }
                            }
                        } else {
                            isaac.x += Movement_Speed;
                        }

                    }
                    break;
            }
        }
    }

}
