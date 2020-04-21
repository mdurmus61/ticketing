package services.planet.ticketing.util;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class TestUtil {
    private static class FilterTestClasses implements PojoClassFilter {
        @Override
        public boolean include(PojoClass pojoClass) {
            return !pojoClass.getSourcePath().contains("/src/test/");
        }
    }

    private static final Validator EVENT_VALIDATOR = ValidatorBuilder.create().with(new GetterTester())
            .with(new SetterTester()).build();

    public static void validateClass(final Class<?> clazz) {
        EVENT_VALIDATOR.validate(PojoClassFactory.getPojoClass(clazz));
    }

    public static void validatePackage(String packageName, final Class... clazz) {
        FilterChain filterProdClassesAndIgnoredClass = new FilterChain(new FilterTestClasses(), pojoClass -> {
            boolean matchFound = false;
            for (int i = 0; i < clazz.length; i++) {
                if (pojoClass.getName().startsWith(clazz[i].getName()))
                    matchFound = true;
            }
            return !matchFound;
        });

        EVENT_VALIDATOR.validate(PojoClassFactory.getPojoClasses(packageName, filterProdClassesAndIgnoredClass));
    }

    public static void validatePackageRecursive(String packageName) {
        EVENT_VALIDATOR.validate(packageName, new FilterPackageInfo());
    }
}
