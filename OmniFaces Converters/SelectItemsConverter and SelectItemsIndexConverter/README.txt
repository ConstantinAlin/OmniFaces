The omnifaces.SelectItemsConverter allows you to populate a selection component with complex Java model objects (entities) as value of <f:selectItems> and have JSF convert those automatically back without the need to provide a custom converter which may need to do the job based on possibly expensive service/DAO operations. This converter automatically converts based on the Object.toString() of the selected item...
http://showcase.omnifaces.org/converters/SelectItemsConverter

The omnifaces.SelectItemsIndexConverter is a variant of the SelectItemsConverter which automatically converts based on the position (index) of the selected item in the list instead of the Object.toString() of the selected item...
http://showcase.omnifaces.org/converters/SelectItemsIndexConverter