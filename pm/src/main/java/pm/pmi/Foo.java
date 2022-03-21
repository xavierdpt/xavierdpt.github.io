package pm;

public class Foo {
    public static void main(String[] args) {
        DevelopProjectCharter developProjectCharter = new DevelopProjectCharter(businessDocuments,agreements,enterpriseEnvironmentalFactors,organizationalProcessAssets);
        developProjectCharter.getExpertJudgment();
        developProjectCharter.getDataGathering();
        developProjectCharter.getInterpersonalAndTeamSkills();
        developProjectCharter.getMeetings();
        DevelopProjectCharter.Result developProjectCharterResult = developProjectCharter.getResult();
        developProjectCharterResult.getProjectCharter();
        developProjectCharterResult.getProjectCharter();
    }
}
