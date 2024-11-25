package com.bergerkiller.bukkit.tc.controller.components;

import java.util.Collection;
import java.util.List;

import com.bergerkiller.bukkit.tc.attachments.animation.Animation;
import com.bergerkiller.bukkit.tc.attachments.animation.AnimationOptions;

/**
 * Interface defining the methods for playing and managing animations.
 * Both trains and individual carts implement this interface.
 */
public interface AnimationController {

    /**
     * Gets a list of unique animation names playable by this controller.
     * Default animation names that operate on the root attachment are not included.
     *
     * @return unmodifiable list of unique animation names
     */
    List<String> getAnimationNames();

    /**
     * Gets a collection of scene names that are defined inside the animation
     * by the name specified. If the animation does not exist, returns an empty
     * collection.
     *
     * @param animationName Name of the animation to get the scene names of
     * @return Scene names
     */
    Collection<String> getAnimationScenes(String animationName);

    /**
     * Plays an animation for a single attachment node. Only the
     * attachment at the targetPath will play the animation.
     *
     * @param targetPath
     * @param options    defining the animation to play
     * @return True if the attachment node and animation could be found
     */
    boolean playNamedAnimationFor(int[] targetPath, AnimationOptions options);

    /**
     * Plays an animation for a single attachment node.
     *
     * @param targetPath indices for the attachment node
     * @param animation  to play
     * @return True if the attachment node could be found
     */
    boolean playAnimationFor(int[] targetPath, Animation animation);

    /**
     * Plays an animation by name. All attachments storing an
     * animation with this name will play.
     *
     * @param name of the animation
     * @return True if an animation was found and started
     */
    default boolean playNamedAnimation(String name) {
        return this.playNamedAnimation(new AnimationOptions(name));
    }

    /**
     * Plays an animation using the animation options specified.
     * All attachments storing an animation with the options' name will play.
     *
     * @param options for the animation
     * @return True if an animation was found and started
     */
    boolean playNamedAnimation(AnimationOptions options);

    /**
     * Adds the option to select an interpolation interperter.
     * There will only be two options for this, which will cover most of the types.
     */
    switch (options.getPlaybackMode()) {
        case LINEAR:
            // Apply linear logic
            break;
        case SINE:
            // Apply sine wave logic
            break;
    }
}
