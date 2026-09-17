package com.taihoang.robotstore.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.taihoang.robotstore")
class ArchitectureTest {

    @ArchTest
    static final ArchRule controllersMustNotAccessRepositoriesDirectly =
            noClasses()
                    .that()
                    .resideInAPackage("..controller..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..repository..")
                    .because("Controller must access Repository through Service");

    @ArchTest
    static final ArchRule entitiesMustNotDependOnControllers =
            noClasses()
                    .that()
                    .resideInAPackage("..entity..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..controller..")
                    .because("Entity must not depend on the web layer");

    @ArchTest
    static final ArchRule rootPackagesMustBeFreeOfCycles =
            slices().matching("com.taihoang.robotstore.(*)..").should().beFreeOfCycles();
}
