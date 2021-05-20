package utility.Interfaces;

import data.StudyGroup;

import java.util.HashSet;

public interface CollectionManagerInterface {

    /**
     * introduce info about collection
     *
     * @see commands.Info#Info
     */
    String getInfo();

    /**
     * Give collection of used id
     */
    HashSet<Integer> getUsedId();

    /**
     * Give collection
     *
     * @see commands.CountLessThanStudentsCount#execute
     * @see commands.FilterStartsWithName#execute
     */
    HashSet<StudyGroup> getCollection();

    /**
     * Set new collection
     */
    void setCollection(HashSet<StudyGroup> studyGroups);

    /**
     * Add element to te collection
     *
     * @see commands.Add#execute
     * @see commands.AddIfMax#execute
     * @see commands.AddIfMin#execute
     */
    void add(StudyGroup studyGroup);

    /**
     * Remove element from collection
     *
     * @see commands.RemoveById#execute
     */
    void remove(StudyGroup studyGroup);

    /**
     * Get minimal element in collection
     *
     * @see commands.AddIfMin#execute
     */
    StudyGroup getMin();

    /**
     * Get maximum element in collection
     *
     * @see commands.AddIfMax#execute
     */
    StudyGroup getMax();

    /**
     * Get study group by id
     *
     * @see commands.RemoveById#execute
     * @see commands.UpdateId#execute
     */
    StudyGroup getId(int id);

    /**
     * Remove all elements of collection
     *
     * @see commands.Clear#execute
     */
    void clear();
}
