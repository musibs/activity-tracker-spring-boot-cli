interface ActivityRepository {
    List<Activity> findAllActivities()
    List<Activity> findActivitiesByDate(Date date)
    void save(Activity activity)
}