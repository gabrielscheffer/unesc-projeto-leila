package net.unesc.locadoravirtual;

import java.util.List;

import net.unesc.locadoravirtual.vo.Filmes;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {
	int mGalleryItemBackground;
	private Context mContext;

	private List<Filmes> mImageIds = DataBase.getFilmes();

	private ImageView[] mImages;

	public ImageAdapter(Context c) {
		mContext = c;
		mImages = new ImageView[getCount()];
	}

	@SuppressWarnings("deprecation")
	public boolean createReflectedImages() {
		// The gap we want between the reflection and the original image
		final int reflectionGap = 4;

		int index = 0;
		for (Filmes imageId : mImageIds) {

			Point outSize = new Point();
			((WindowManager) mContext.getSystemService(mContext.WINDOW_SERVICE))
					.getDefaultDisplay().getSize(outSize);
			Integer heightT = outSize.y;
			Integer imageHeight = 200;
			if (heightT != null) {
				imageHeight = (heightT / 8) * 4;
			}

			Bitmap originalImage = resizeImage(BitmapFactory.decodeResource(
					mContext.getResources(), imageId.getImage()), imageHeight,
					mContext);
			int width = originalImage.getWidth();
			int height = originalImage.getHeight();

			// This will not scale but will flip on the Y axis
			Matrix matrix = new Matrix();
			matrix.preScale(1, -1);

			// Create a Bitmap with the flip matrix applied to it.
			// We only want the bottom half of the image
			Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0,
					height / 2, width, height / 2, matrix, true);

			// Create a new bitmap with same width but taller to fit
			// reflection
			Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
					(height + height / 2), Config.ARGB_8888);

			// Create a new Canvas with the bitmap that's big enough for
			// the image plus gap plus reflection
			Canvas canvas = new Canvas(bitmapWithReflection);
			// Draw in the original image
			canvas.drawBitmap(originalImage, 0, 0, null);
			// Draw in the gap
			Paint deafaultPaint = new Paint();
			canvas.drawRect(0, height, width, height + reflectionGap,
					deafaultPaint);
			// Draw in the reflection
			canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

			// Create a shader that is a linear gradient that covers the
			// reflection
			Paint paint = new Paint();
			LinearGradient shader = new LinearGradient(0,
					originalImage.getHeight(), 0,
					bitmapWithReflection.getHeight() + reflectionGap,
					0x70ffffff, 0x00ffffff, TileMode.CLAMP);
			// Set the paint to use this shader (linear gradient)
			paint.setShader(shader);
			// Set the Transfer mode to be porter duff and destination in
			paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
			// Draw a rectangle using the paint with our linear gradient
			canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()
					+ reflectionGap, paint);

			ImageView imageView = new ImageView(mContext);
			imageView.setImageBitmap(bitmapWithReflection);
			imageView.setLayoutParams(new CoverFlow.LayoutParams(
					outSize.x / 4 > width ? outSize.x / 4 : width, height
							+ height / 2));
			imageView.setScaleType(ScaleType.MATRIX);
			mImages[index++] = imageView;
		}
		return true;
	}

	public int getCount() {
		return mImageIds.size();
	}

	public Object getItem(int position) {
		// Log.d("GABRIEL", "getItem Clicado na posição >>" + position);
		return position;
	}

	public long getItemId(int position) {
		// Log.d("GABRIEL", "getItemID Clicado na posição >>" + position);
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// Log.d("GABRIEL", "getView Clicado na posição >>" + position);

		return mImages[position];
	}

	/**
	 * Returns the size (0.0f to 1.0f) of the views depending on the 'offset' to
	 * the center.
	 */
	public float getScale(boolean focused, int offset) {
		/* Formula: 1 / (2 ^ offset) */
		return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
	}

	public static Bitmap resizeImage(Bitmap imagem, Integer maxHeight,
			Context context) {

		int width = imagem.getWidth();
		int height = imagem.getHeight();
		int newWidth = ((width * maxHeight) / height);
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) maxHeight) / height;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap resizedBitmap = Bitmap.createBitmap(imagem, 0, 0, width, height,
				matrix, true);
		return resizedBitmap;
	}

}
