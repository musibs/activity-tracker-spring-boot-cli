@Repository
class DefaultActivityRepository implements ActivityRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    List<Activity> findAllActivities() {
        jdbcTemplate.query("""select id, activityName, completed, activityDate 
        from Activities""", {
            resultSet, newRow -> new Activity(
                id : resultSet.getLong(1),
                activityName : resultSet.getString(2),
                completed : resultSet.getString(3),
                activityDate : resultSet.getDate(4))
         } as RowMapper)
    }

    List<Activity> findActivitiesByDate(Date date) {
        jdbcTemplate.query("""select id, activityName, completed, activityDate 
        from Activities where activityDate=?""", {
            resultSet, newRow -> new Activity(
                id : resultSet.getLong(1),
                activityName : resultSet.getString(2),
                completed : resultSet.getString(3),
                activityDate : resultSet.getDate(4))
         } as RowMapper, date)
    }
    
    void save(Activity activity) {
        jdbcTemplate.update("""insert into Activities (id, activityName, completed, activityDate)
            values(?, ?, ?, ?)""", 
            activity.id, 
            activity.activityName, 
            activity.completed, 
            activity.activityDate)
    }
}