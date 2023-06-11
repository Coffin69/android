public class FuelTypeAdapter extends ArrayAdapter<FuelType> {
    private Context context;
    private List<FuelType> fuelTypes;

    public FuelTypeAdapter(Context context, List<FuelType> fuelTypes) {
        super(context, 0, fuelTypes);
        this.context = context;
        this.fuelTypes = fuelTypes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item_fuel_type, parent, false);
        }

        FuelType currentFuelType = fuelTypes.get(position);

        TextView textViewFuelTypeName = listItemView.findViewById(R.id.textViewFuelTypeName);
        textViewFuelTypeName.setText(currentFuelType.getName());

        TextView textViewFuelTypeQuantity = listItemView.findViewById(R.id.textViewFuelTypeQuantity);
        textViewFuelTypeQuantity.setText(String.valueOf(currentFuelType.getQuantity()));

        TextView textViewFuelTypeNextDeliveryDate = listItemView.findViewById(R.id.textViewFuelTypeNextDeliveryDate);
        textViewFuelTypeNextDeliveryDate.setText(currentFuelType.getNextDeliveryDate());

        return listItemView;
    }
}
