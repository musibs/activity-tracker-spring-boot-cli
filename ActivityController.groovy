import java.text.SimpleDateFormat

@Grab("h2")
@Grab("spring-boot-starter-thymeleaf")
@Controller
@RequestMapping("/")
class ActivityController {

    @Autowired
    ActivityRepository activityRepository;

    @GetMapping
    def getAllActivities(Model model) {
        List<Activity> activities = activityRepository.findAllActivities();
        model.addAttribute("activities", activities)
        "activities"
    }

    @GetMapping("{activityDate}")
    def getActivitiesByDate(@PathVariable("activityDate") String activityDate, Model model) {
        def dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Activity> activities = activityRepository
        .findActivitiesByDate(dateFormat.parse(activityDate));
        model.addAttribute("activities", activities)
        "activities"
    }

    @PostMapping
    def addAacivity(Activity activity) {
        activityRepository.save(activity);
        "redirect:/"
    }
}