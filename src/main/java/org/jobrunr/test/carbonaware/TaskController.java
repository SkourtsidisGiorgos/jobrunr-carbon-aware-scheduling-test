package org.jobrunr.test.carbonaware;

import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.cron.CarbonAwareCron;
import org.jobrunr.utils.carbonaware.CarbonAwarePeriod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.HOURS;

@RestController
public class TaskController {

    @GetMapping("/schedule-carbon-aware-task")
    public void createNewTaskBetween(@RequestParam String message, @RequestParam int startHoursAhead, @RequestParam int endHoursAhead) {
        BackgroundJob.scheduleCarbonAware(CarbonAwarePeriod.between(Instant.now().plus(startHoursAhead, HOURS), Instant.now().plus(endHoursAhead, HOURS)),
                () -> System.out.println("Carbon Aware Task: " + message));
    }

    @GetMapping("/create-carbon-aware-recurring-job-daily-between")
    public void createNewTaskBetween(@RequestParam int allowedHourToStart, @RequestParam int allowedHourToEnd) {
        BackgroundJob.scheduleRecurrently(UUID.randomUUID().toString(), CarbonAwareCron.dailyBetween(allowedHourToStart, allowedHourToEnd),
                () -> System.out.println("Carbon Aware Recurring Task between " + allowedHourToStart + " and " + allowedHourToEnd));
    }
}