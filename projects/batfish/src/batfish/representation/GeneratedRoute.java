package batfish.representation;

import java.util.Set;

public class GeneratedRoute extends Route {

   private static final long serialVersionUID = 1L;

   private int _administrativeCost;

   private AsPath _asPath;

   private boolean _discard;

   private Set<PolicyMap> _generationPolicies;

   private Integer _metric;

   public GeneratedRoute(Ip prefix, int prefixLength, int administrativeCost,
         Set<PolicyMap> generationPolicyMaps) {
      super(prefix, prefixLength, null);
      _administrativeCost = administrativeCost;
      _generationPolicies = generationPolicyMaps;
   }

   @Override
   public boolean equals(Object o) {
      GeneratedRoute rhs = (GeneratedRoute) o;
      return _prefix.equals(rhs._prefix) && _prefixLength == rhs._prefixLength;
   }

   @Override
   public int getAdministrativeCost() {
      return _administrativeCost;
   }

   public AsPath getAsPath() {
      return _asPath;
   }

   public boolean getDiscard() {
      return _discard;
   }

   public Set<PolicyMap> getGenerationPolicies() {
      return _generationPolicies;
   }

   public Integer getMetric() {
      return _metric;
   }

   @Override
   public RouteType getRouteType() {
      return RouteType.AGGREGATE;
   }

   public void setAdministrativePreference(int preference) {
      _administrativeCost = preference;
   }

   public void setAsPath(AsPath asPath) {
      _asPath = asPath;
   }

   public void setDiscard(boolean discard) {
      _discard = discard;
   }

   public void setMetric(int metric) {
      _metric = metric;
   }

}
