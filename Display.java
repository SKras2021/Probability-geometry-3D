import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;

public class Display extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	private	Scanner sc1 = new Scanner(System.in);
	private Thread thread;
	private JFrame frame;
	private static String title =  "3D Renderer";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private static boolean running = false;
	private EntityManager entityManager;
	private Mouse mouse;
	public int num = 0;
	public int totalCubes = 0;

	public Display() {
		this.frame = new JFrame();

		Dimension size = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(size);

		this.mouse = new Mouse();

		this.entityManager = new EntityManager();

		this.addMouseListener(this.mouse);
		this.addMouseMotionListener(this.mouse);
		this.addMouseWheelListener(this.mouse);
	}

	public static void main(String[] args){
		Display display = new Display();
		display.frame.setTitle(title);
		display.frame.add(display);
		display.frame.pack();
		display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.frame.setLocationRelativeTo(null);
		display.frame.setResizable(false);
		display.frame.setVisible(true);

		System.out.println("Enter number of cubes");
		display.totalCubes = display.sc1.nextInt();

		display.start();
		
	}

	public synchronized void start(){
		running = true;
		this.thread = new Thread(this, "Display");
		this.thread.start();
	}

	public synchronized void stop(){
		running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		} 
	}

	public void run(){
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60;
		double delta = 0;
		int frames = 0;
		probGeom3D pg3 = new probGeom3D();
		int[][] installer = pg3.getArray(totalCubes);
		this.entityManager.init(installer, totalCubes);

		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1){
				num++;
				update();
				delta--;
				render();
				frames++;
			}
			

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				this.frame.setTitle(title + " | " + frames + " fps");
				frames = 0;
			}
		}

		stop();
	}

	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(20, 20, 20));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		
		this.entityManager.render(g);
		
		g.dispose();
		bs.show();
	}

	int prevMouse = -1;
	int initialX, initialY;

	public void rotate(){
		//Do not need this, just to overide
	}

	private void update(){
		this.entityManager.update(this.mouse);
	}
}
