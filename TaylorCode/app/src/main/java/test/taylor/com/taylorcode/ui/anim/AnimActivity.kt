package test.taylor.com.taylorcode.ui.anim

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import test.taylor.com.taylorcode.R
import test.taylor.com.taylorcode.util.BitmapUtil
import test.taylor.com.taylorcode.util.DimensionUtil


class AnimActivity : Activity(), View.OnClickListener {

    private var ivFrameAnim: ImageView? = null
    private var animationDrawable: AnimationDrawable? = null

    private val tvScaleAnim: TextView? = null
    private var tvValueAnimator: TextView? = null
    private var ivArrow: ImageView? = null
    private var tvTranslateAnimation: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anim_activity)
        initView()

        createValueAnimator()
        doAnimatorSet(20, 50)
    }


    private fun initView() {
        ivFrameAnim = findViewById<View>(R.id.frame_anim) as ImageView
        animationDrawable = createAnimationDrawable(this)
        ivFrameAnim!!.setImageDrawable(animationDrawable)
        ivFrameAnim!!.setOnClickListener(this)

        tvValueAnimator = findViewById<View>(R.id.tv_value_animator) as TextView
        tvTranslateAnimation = findViewById<View>(R.id.tv_anim_translation) as TextView
        ivArrow = findViewById<View>(R.id.iv_notify_down) as ImageView
        ivArrow!!.setOnClickListener(this)
        tvTranslateAnimation!!.setOnClickListener(this)

        // scale anim case1: create scale anim
        //        tvScaleAnim = createTextView(this);
        //        ((LinearLayout) findViewById(R.id.ll_animi_activity_root)).addView(tvScaleAnim);
        //        tvScaleAnim.startAnimation(createScaleAnimation());
    }

    /**
     * frame anim case 1:create frame anim with compressed bitmap
     *
     * @param context
     * @return
     */
    private fun createAnimationDrawable(context: Context): AnimationDrawable {
        val drawable = AnimationDrawable()
        val frameDuration = BOMB_ANIM_DURATION_IN_MILLISECOND / 21
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_1, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_2, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_3, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_4, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_5, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_6, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_7, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_8, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_9, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_10, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_11, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_12, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_13, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_14, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_15, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_16, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_17, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_18, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_19, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_20, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_21, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.addFrame(BitmapDrawable(BitmapUtil.decodeSampledBitmapFromResource(context.resources, R.drawable.watch_reward_22, DimensionUtil.dp2px(54.0), DimensionUtil.dp2px(54.0))), frameDuration)
        drawable.isOneShot = true
        return drawable
    }


    private fun createTextView(context: Context): TextView {
        val tv = TextView(context)
        val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        tv.text = "+1"
        tv.textSize = 20f
        tv.setTextColor(Color.parseColor("#FFDD00"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.layoutParams = params
        return tv
    }

    /**
     * scale anim case1: create scale anim
     *
     * @return
     */
    private fun createScaleAnimation(): ScaleAnimation {
        val animation = ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        animation.fillBefore = true
        animation.duration = 300
        animation.repeatCount = 100
        animation.repeatMode = Animation.INFINITE
        return animation
    }

    /**
     * animator case1:create value animator
     */
    private fun createValueAnimator() {
        val animator = ValueAnimator.ofFloat(15f, 25f)
        animator.interpolator = AccelerateInterpolator()
        animator.addUpdateListener { animation -> Log.v("ttaylor", "AnimActivity.onAnimationUpdate()" + "  value=" + animation.animatedValue) }
        animator.start()
    }

    /**
     * animator case3:create several value animator and put them together in AnimatorSet
     */
    private fun doAnimatorSet(start: Int, end: Int) {
        tvValueAnimator!!.alpha = 1f
        val animator = ValueAnimator.ofFloat(start.toFloat(), end.toFloat())
        animator.interpolator = AccelerateInterpolator()
        animator.duration = VALUE_ANIM_DURATION_IN_MILLISECOND.toLong()

        val animator1 = ValueAnimator.ofFloat(end.toFloat(), end.toFloat())
        animator1.duration = REWARD_NUMBER_STAY_TIME_IN_MILLISECOND.toLong()

        val animator2 = ValueAnimator.ofInt(1, 0)
        animator2.duration = REWARD_NUMBER_FADE_TIME_IN_MILLISECOND.toLong()

        val set = AnimatorSet()
        set.playSequentially(animator, animator1, animator2)
        set.startDelay = BOMB_ANIM_DURATION_IN_MILLISECOND.toLong()

        animator.addUpdateListener { animation ->
            val size = animation.animatedValue as Float
            tvValueAnimator!!.textSize = size
        }
        animator1.addUpdateListener { animation ->
            val size = animation.animatedValue as Float
            tvValueAnimator!!.textSize = size
        }
        animator2.addUpdateListener { animation ->
            val alpha = animation.animatedValue as Int
            tvValueAnimator!!.alpha = alpha.toFloat()
        }
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                tvValueAnimator!!.text = "+" + 1
            }

            override fun onAnimationEnd(animation: Animator) {

            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        })
        animator2.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {

            }

            override fun onAnimationEnd(animation: Animator) {
                tvValueAnimator!!.text = ""
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        })
        set.start()
    }


    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.frame_anim -> {
                //stop first is must or start wont work when clicking twice
                if (animationDrawable!!.isRunning) {
                    animationDrawable!!.stop()
                }
                animationDrawable!!.start()
            }
            R.id.tv_anim_translation ->
                //                doTranslateAnimation();
                doReverseTranslateAnimationByValueAnimator()
            R.id.iv_notify_down -> doVerticalTranslateAnimation()
            else -> {
            }
        }
    }

    private fun doVerticalTranslateAnimation() {
        val objectAnimator = ObjectAnimator.ofFloat(ivArrow, "translationY", 0f, DimensionUtil.dp2px(10.0).toFloat(), 0f, DimensionUtil.dp2px(10.0).toFloat())
        objectAnimator.setInterpolator(AccelerateDecelerateInterpolator())
        objectAnimator.setDuration(600)
        objectAnimator.start()
    }

    /**
     * animation case1:do TranslateAnimation back and forth by INFINITE repeat mode
     */
    private fun doTranslateAnimation() {
        val animation = TranslateAnimation(0f, 100f, 0f, 0f)
        animation.duration = 300
        animation.repeatMode = Animation.INFINITE
        animation.interpolator = AccelerateDecelerateInterpolator()
        animation.repeatCount = 100
        tvTranslateAnimation!!.startAnimation(animation)
    }


    /**
     * animator case4:do animation back and forth by ObjectAnimator
     */
    private fun doReverseTranslateAnimationByValueAnimator() {
        val originLeft = tvTranslateAnimation!!.left
        val objectAnimator = ObjectAnimator.ofFloat(tvTranslateAnimation, "translationX", originLeft.toFloat(), (originLeft + 100).toFloat(), 0f)
        objectAnimator.setInterpolator(AccelerateDecelerateInterpolator())
        objectAnimator.setDuration(300)
        objectAnimator.start()
    }

    companion object {
        private val BOMB_ANIM_DURATION_IN_MILLISECOND = 6 * 100
        private val VALUE_ANIM_DURATION_IN_MILLISECOND = 500
        private val REWARD_NUMBER_STAY_TIME_IN_MILLISECOND = 1500
        private val REWARD_NUMBER_FADE_TIME_IN_MILLISECOND = 500
    }
}