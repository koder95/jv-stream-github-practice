package practice;

import java.util.function.Predicate;
import model.Candidate;

/**
 * The requirements are: person should be older than 35 years, should be allowed to vote,
 * have nationality - 'Ukrainian'
 * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
 * which has following view: "2002-2015"
 */
public class CandidateValidator implements Predicate<Candidate> {

    private static final int AGE_REQUIREMENT = 35;
    private static final int LIVING_IN_UKR_REQUIREMENT = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        boolean isUkrainian = REQUIRED_NATIONALITY.equals(candidate.getNationality());
        boolean isOlderThan35 = candidate.getAge() >= AGE_REQUIREMENT;
        boolean allowedToVote = candidate.isAllowedToVote();
        String[] split = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(split[0]);
        int endYear = Integer.parseInt(split[1]);
        int inUkr = endYear - startYear;
        boolean living10YearsInUkr = inUkr >= LIVING_IN_UKR_REQUIREMENT;
        return isOlderThan35 && allowedToVote && isUkrainian && living10YearsInUkr;
    }
}
