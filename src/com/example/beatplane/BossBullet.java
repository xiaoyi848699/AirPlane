package com.example.beatplane;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
/*boos敌机的子弹*/
public class BossBullet extends GameObject{
	private Bitmap bullet; 		 // 子弹的图片
	BossBullet(Resources resources) {
		super(resources);
		initBitmap();
	}

	// 初始化数据
	@Override
	public void initial(int arg0,float arg1,float arg2,int arg3) {
		isAlive = true;
		harm = 1;
		speed = 20;	
		object_x = arg1 - object_width / 2;
		object_y = arg2 - object_height;
	}
	//初始化图片
	@Override
	public void initBitmap() {
		// TODO Auto-generated method stub
		bullet = BitmapFactory.decodeResource(resources, R.drawable.bossbullet);
		object_width = bullet.getWidth();
		object_height = bullet.getHeight();
	}
	// 绘图函数
	@Override
	public void drawSelf(Canvas canvas) {
		// TODO Auto-generated method stub
		if (isAlive) {
			canvas.save();
			canvas.clipRect(object_x, object_y, object_x + object_width,
					object_y + object_height);
			canvas.drawBitmap(bullet, object_x, object_y, paint);
			canvas.restore();
			logic();
		}
	}
	@Override
	public void release(){
		if(!bullet.isRecycled()){
			bullet.recycle();
		}
	}
	// 对象的逻辑函数
	@Override
	public void logic() {
		if (object_y <= screen_height) {
			object_y += speed;
		} else {
			isAlive = false;
		}
	}
	// 检测碰撞
	@Override
	public boolean isCollide(GameObject obj) {
		return super.isCollide(obj);
	}
}
