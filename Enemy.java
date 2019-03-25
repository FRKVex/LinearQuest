import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject {
	
	private Handler handler;
	Random r = new Random();
	int choose = 0;
	int hp = 100;
	
	public Enemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

	}

	public void tick() {
		x += velX;
		y += velY;
		
		choose = r.nextInt(10);
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block) {
				if(getBoundsRadius().intersects(tempObject.getBounds())) {
					velX += (velX*2) * - 1;
					velY += (velY*2) * - 1;
				}else if (choose == 0) {
					velX = (r.nextInt(4 - -4) + -4);
					velY = (r.nextInt(4 - -4) + -4);
				}
			}
			if(getBoundsRadius().intersects(tempObject.getBounds())) {
				if(tempObject.getId() == ID.Bullet) {
					hp -= 50;
					handler.removeObject(tempObject);
				}
			}
		}
		
		if(hp <= 0) handler.removeObject(this);
	}

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 32, 32);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.GREEN);
		g2d.draw(getBoundsRadius());
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public Rectangle getBoundsRadius() {
		return new Rectangle(x-16, y-16, 64, 64);
	}

}
