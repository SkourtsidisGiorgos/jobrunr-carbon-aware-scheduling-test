package org.jobrunr.test.carbonaware;

import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.utils.carbonaware.CarbonAwarePeriod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.HOURS;

@RestController
public class TaskController {

    @GetMapping("/schedule-carbon-aware-task")
    public void createNewTask(@RequestParam String message, @RequestParam int hoursAheadDeadline) {
        BackgroundJob.scheduleCarbonAware(CarbonAwarePeriod.before(Instant.now().plus(hoursAheadDeadline, HOURS)),
                () -> System.out.println("Carbon Aware Task: " + message));
    }

    @GetMapping("/schedule-carbon-aware-task-between")
    public void createNewTaskBetween(@RequestParam String message, @RequestParam int startHoursAhead, @RequestParam int endHoursAhead) {
        BackgroundJob.scheduleCarbonAware(CarbonAwarePeriod.between(Instant.now().plus(startHoursAhead, HOURS), Instant.now().plus(endHoursAhead, HOURS)),
                () -> System.out.println("Carbon Aware Task: " + message));
    }
}
